/**
 *    Copyright 2006  Rahul Thakur
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.faqbot.analyzer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import com.ibm.uima.UIMAFramework;
import com.ibm.uima.analysis_engine.AnalysisEngineProcessException;
import com.ibm.uima.analysis_engine.TextAnalysisEngine;
import com.ibm.uima.cas.CAS;
import com.ibm.uima.cas.FSIterator;
import com.ibm.uima.cas.Feature;
import com.ibm.uima.cas.FeatureStructure;
import com.ibm.uima.cas.FloatArrayFS;
import com.ibm.uima.cas.IntArrayFS;
import com.ibm.uima.cas.StringArrayFS;
import com.ibm.uima.cas.Type;
import com.ibm.uima.cas.text.AnnotationFS;
import com.ibm.uima.cas.text.TCAS;
import com.ibm.uima.resource.ResourceSpecifier;
import com.ibm.uima.util.XMLInputSource;

/**
 * @author <a href="mailto:rahul.thakur.xdev@gmail.com">Rahul Thakur</a>
 * @revision $Id$
 */
public class TextAnalyzer {

    /**
     * FIXME: Hard-coded!<br>
     * Path to the resources directory.
     */
    private static final String RESOURCE_DIR = "E:\\faqbot\\sandbox\\faqbot-uima\\src\\resources";


    /**
     * Main program.
     * 
     * @param args
     *            Command-line arguments - see class description
     */
    public static void main(String [] args) {
        try {
            File taeDescriptor = null;
            File inputDir = null;

            // Read and validate command line arguments
            boolean validArgs = true;
            // XXX: Provide the TAE descriptor and
            // input data dir
            taeDescriptor = new File (RESOURCE_DIR + "\\descriptors\\SimpleTextDescriptor.xml");
            inputDir = new File (RESOURCE_DIR + "\\data");

            if (!validArgs) {
                printUsageMessage ();
            } else {
                // get Resource Specifier from XML file
                XMLInputSource in = new XMLInputSource (taeDescriptor);
                ResourceSpecifier specifier = UIMAFramework.getXMLParser ().parseResourceSpecifier (in);

                // for debugging, output the Resource Specifier
                // System.out.println(specifier);

                // create Text Analysis Engine and TCAS
                TextAnalysisEngine tae = UIMAFramework.produceTAE (specifier);
                TCAS tcas = tae.newTCAS ();

                // get all files in the input directory
                File [] files = inputDir.listFiles ();
                if (files == null) {
                    System.out.println ("No files to process");
                } else {
                    // process documents
                    for (int i = 0; i < files.length; i++) {
                        if (!files[i].isDirectory ()) {
                            processFile (files[i], tae, tcas);
                        }
                    }
                }
                tae.destroy ();
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }


    /**
     * Prints usage message.
     */
    private static void printUsageMessage() {
        System.err.println ("Usage: java com.ibm.uima.example.ExampleApplication " + "<TAE descriptor or TEAR file name> <input dir> <output dir>");
    }


    /**
     * Processes a single XML file and prints annotations to System.out
     * 
     * @param aFile
     *            file to process
     * @param aTAE
     *            Text Analysis Engine that will process the file
     * @param aTCAS
     *            TCAS that will be used to hold analysis results
     */
    private static void processFile(File aFile, TextAnalysisEngine aTAE, TCAS aTCAS) throws IOException, AnalysisEngineProcessException {
        System.out.println ("Processing file " + aFile.getName ());
        FileInputStream fis = null;

        try {
            // read file
            fis = new FileInputStream (aFile);
            byte [] contents = new byte[(int) aFile.length ()];
            fis.read (contents);
            String document = new String (contents, "UTF-8");
            document = document.trim ();

            // put document text in TCAS
            aTCAS.setDocumentText (document);

            // process
            aTAE.process (aTCAS);

            // print annotations to System.out
            printAnnotations (aTCAS, System.out);

            // reset TCAS to prepare it for processing the next document
            aTCAS.reset ();
        } finally {
            try {
                if (fis != null)
                    fis.close ();
            } catch (Exception ex) {
                ex.printStackTrace ();
            }
        }
    }


    /**
     * Prints all Annotations to a PrintStream.
     * 
     * @param aTCAS
     *            the TCAS containing the FeatureStructures to print
     * @param aOut
     *            the PrintStream to which output will be written
     */
    public static void printAnnotations(TCAS aTCAS, PrintStream aOut) {
        // get iterator over annotations
        FSIterator iter = aTCAS.getAnnotationIndex ().iterator ();

        // iterate
        while (iter.isValid ()) {
            FeatureStructure fs = iter.get ();
            printFS (fs, aTCAS, 0, aOut);
            iter.moveToNext ();
        }
    }


    /**
     * Prints all Annotations of a specified Type to a PrintStream.
     * 
     * @param aTCAS
     *            the TCAS containing the FeatureStructures to print
     * @param aAnnotType
     *            the Type of Annotation to be printed
     * @param aOut
     *            the PrintStream to which output will be written
     */
    public static void printAnnotations(TCAS aTCAS, Type aAnnotType, PrintStream aOut) {
        // get iterator over annotations
        FSIterator iter = aTCAS.getAnnotationIndex (aAnnotType).iterator ();

        // iterate
        while (iter.isValid ()) {
            FeatureStructure fs = iter.get ();
            printFS (fs, aTCAS, 0, aOut);
            iter.moveToNext ();
        }
    }


    /**
     * Prints a FeatureStructure to a PrintStream.
     * 
     * @param aFS
     *            the FeatureStructure to print
     * @param aTCAS
     *            the TCAS containing the FeatureStructure
     * @param aNestingLevel
     *            number of tabs to print before each line
     * @param aOut
     *            the PrintStream to which output will be written
     */
    public static void printFS(FeatureStructure aFS, TCAS aTCAS, int aNestingLevel, PrintStream aOut) {
        Type stringType = aTCAS.getTypeSystem ().getType (CAS.TYPE_NAME_STRING);

        printTabs (aNestingLevel, aOut);
        aOut.println (aFS.getType ().getName ());

        // if it's an annotation, print the first 64 chars of its covered text
        if (aFS instanceof AnnotationFS) {
            AnnotationFS annot = (AnnotationFS) aFS;
            String coveredText = annot.getCoveredText ();
            printTabs (aNestingLevel + 1, aOut);
            aOut.print ("\"");
            if (coveredText.length () <= 64) {
                aOut.print (coveredText);
            } else {
                aOut.println (coveredText.substring (0, 64) + "...");
            }
            aOut.println ("\"");
        }

        // print all features
        List aFeatures = aFS.getType ().getAppropriateFeatures ();
        Iterator iter = aFeatures.iterator ();
        while (iter.hasNext ()) {
            Feature feat = (Feature) iter.next ();
            printTabs (aNestingLevel + 1, aOut);
            // print feature name
            aOut.print (feat.getShortName ());
            aOut.print (" = ");
            // prnt feature value (how we get this depends on feature's range
            // type)
            String rangeTypeName = feat.getRange ().getName ();
            if (aTCAS.getTypeSystem ().subsumes (stringType, feat.getRange ())) // must
                                                                                // check
                                                                                // for
                                                                                // subtypes
                                                                                // of
                                                                                // string
            {
                String str = aFS.getStringValue (feat);
                if (str == null) {
                    aOut.println ("null");
                } else {
                    aOut.print ("\"");
                    if (str.length () > 64) {
                        str = str.substring (0, 64) + "...";
                    }
                    aOut.print (str);
                    aOut.println ("\"");
                }
            } else if (CAS.TYPE_NAME_INTEGER.equals (rangeTypeName)) {
                aOut.println (aFS.getIntValue (feat));
            } else if (CAS.TYPE_NAME_FLOAT.equals (rangeTypeName)) {
                aOut.println (aFS.getFloatValue (feat));
            } else if (CAS.TYPE_NAME_STRING_ARRAY.equals (rangeTypeName)) {
                StringArrayFS arrayFS = (StringArrayFS) aFS.getFeatureValue (feat);
                if (arrayFS == null) {
                    aOut.println ("null");
                } else {
                    String [] vals = arrayFS.toArray ();
                    aOut.print ("[");
                    for (int i = 0; i < vals.length - 1; i++) {
                        aOut.print (vals[i]);
                        aOut.print (',');
                    }
                    if (vals.length > 0) {
                        aOut.print (vals[vals.length - 1]);
                    }
                    aOut.println ("]\"");
                }
            } else if (CAS.TYPE_NAME_INTEGER_ARRAY.equals (rangeTypeName)) {
                IntArrayFS arrayFS = (IntArrayFS) aFS.getFeatureValue (feat);
                if (arrayFS == null) {
                    aOut.println ("null");
                } else {
                    int [] vals = arrayFS.toArray ();
                    aOut.print ("[");
                    for (int i = 0; i < vals.length - 1; i++) {
                        aOut.print (vals[i]);
                        aOut.print (',');
                    }
                    if (vals.length > 0) {
                        aOut.print (vals[vals.length - 1]);
                    }
                    aOut.println ("]\"");
                }
            } else if (CAS.TYPE_NAME_FLOAT_ARRAY.equals (rangeTypeName)) {
                FloatArrayFS arrayFS = (FloatArrayFS) aFS.getFeatureValue (feat);
                if (arrayFS == null) {
                    aOut.println ("null");
                } else {
                    float [] vals = arrayFS.toArray ();
                    aOut.print ("[");
                    for (int i = 0; i < vals.length - 1; i++) {
                        aOut.print (vals[i]);
                        aOut.print (',');
                    }
                    if (vals.length > 0) {
                        aOut.print (vals[vals.length - 1]);
                    }
                    aOut.println ("]\"");
                }
            } else // non-primitive type
            {
                FeatureStructure val = aFS.getFeatureValue (feat);
                if (val == null) {
                    aOut.println ("null");
                } else {
                    printFS (val, aTCAS, aNestingLevel + 1, aOut);
                }
            }
        }
    }


    /**
     * Prints tabs to a PrintStream.
     * 
     * @param aNumTabs
     *            number of tabs to print
     * @param aOut
     *            the PrintStream to which output will be written
     */
    private static void printTabs(int aNumTabs, PrintStream aOut) {
        for (int i = 0; i < aNumTabs; i++) {
            aOut.print ("\t");
        }
    }

}

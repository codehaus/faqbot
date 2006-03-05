/**************************************************************************/
/*  Licensed Materials - Property of IBM                                  */
/*  (C) Copyright IBM Corporation 2003, 2004.                             */
/*  All rights reserved.                                                  */		
/*                                                                        */
/* US Government Users Restricted Rights - Use, duplication or            */
/* disclosure restricted by GSA ADP Schedule Contract with                */
/* IBM Corporation.                                                       */
/**************************************************************************/
/*  Permission Notice                                                     */
/*                                                                        */
/*  Permission is granted to copy, use, modify, and merge this sample     */
/*  software into your applications and to permit others to do any of the */
/*  foregoing. You may further distribute this software for               */
/*  commercial purposes only as part of your application that adds        */
/*  significant value and function beyond that provided by these          */
/*  samples.                                                              */
/*  You must include this permission statement and retain the copyright   */
/*  notice in all copies and modified versions of this software.          */
/*                                                                        */
/**************************************************************************/
/*                                                                        */
/*  DISCLAIMER OF WARRANTIES                                              */
/*                                                                        */
/*  The sample software is provided to you by IBM to assist you in        */
/*  developing your applications. THIS SOFTWARE IS PROVIDED AS-IS,        */
/*  WITHOUT WARRANTY OF ANY KIND. IBM SHALL NOT BE LIABLE FOR ANY         */
/*  DAMAGES ARISING OUT OF YOUR USE OR THE USE BY ANY THIRD PARTY OF      */
/*  OF THE SAMPLE SOFTWARE EVEN IF IT HAS BEEN ADVISED OF THE POSSIBILITY */
/*  OF SUCH DAMAGES. IN ADDITION, IBM SHALL NOT BE LIABLE FOR ANY THIRD   */
/*  PARTY CLAIMS AGAINST YOU.                                             */
/*                                                                        */
/**************************************************************************/

package org.codehaus.faqbot.annotator;

import java.text.BreakIterator;
import java.text.ParsePosition;
import java.util.Locale;

import com.ibm.uima.analysis_engine.ResultSpecification;
import com.ibm.uima.analysis_engine.annotator.AnnotatorProcessException;
import com.ibm.uima.analysis_engine.annotator.Annotator_ImplBase;
import com.ibm.uima.analysis_engine.annotator.JTextAnnotator;
import com.ibm.uima.jcas.impl.JCas;
import com.ibm.uima.jcas.tcas.Annotation;


/**
 * An example annotator that annotates Tokens and Sentences.
 */
public class SimpleTokenAndSentenceAnnotator 
       extends Annotator_ImplBase 
       implements JTextAnnotator{
       	
  static abstract class Maker {
  	abstract Annotation newAnnotation(JCas jcas, int start, int end);
  }
       	
  JCas jcas;
  String input;
	ParsePosition pp = new ParsePosition(0);

  //****************************************
  //*  Static vars holding break iterators
  //****************************************
	static final BreakIterator sentenceBreak = BreakIterator.getSentenceInstance(Locale.US);
	static final BreakIterator wordBreak = BreakIterator.getWordInstance(Locale.US);
   
  //*********************************************
  //*   function pointers for new instances     *
  //*********************************************
  static final Maker sentenceAnnotationMaker =
	  new Maker() { 
	  	Annotation newAnnotation(JCas jcas, int start, int end) {
				return new Sentence(jcas, start, end);}};

	static final Maker tokenAnnotationMaker =
		new Maker() { 
			Annotation newAnnotation(JCas jcas, int start, int end) {
				return new Token(jcas, start, end);}};
 
  //*************************************************************
  //*                        process                            *
  //*************************************************************      	
  public void process(JCas jcas, ResultSpecification aResultSpec)
       throws AnnotatorProcessException {
    this.jcas = jcas;
    input = jcas.getDocumentText();

    //Create Annotations 
    makeAnnotations(sentenceAnnotationMaker, sentenceBreak);
    makeAnnotations(tokenAnnotationMaker, wordBreak);		
	}
	
	//*************************************************************
	//*                Helper Methods                             *
	//*************************************************************      	
  void makeAnnotations(Maker m, BreakIterator b){
  	b.setText(input);
		for (int end = b.next(), start = b.first(); 
		     end != BreakIterator.DONE; 
		     start = end, end = b.next()) {
		  //eliminate all-whitespace tokens
		  boolean isWhitespace = true;
		  for (int i = start; i< end; i++)
		  {
		  	if (!Character.isWhitespace(input.charAt(i)))
		  	{
		  		isWhitespace = false;
		  		break;   	
		  	}
		  }
			if (!isWhitespace)
			{
			  m.newAnnotation(jcas, start, end).addToIndexes(); 
			} 
		}
  }
}

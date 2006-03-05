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
/* Generated by JCasGen Wed May 05 14:41:10 EDT 2004*/

package org.codehaus.faqbot.annotator;

import com.ibm.uima.cas.FeatureStructure;
import com.ibm.uima.cas.Type;
import com.ibm.uima.cas.impl.CASImpl;
import com.ibm.uima.cas.impl.FSGenerator;
import com.ibm.uima.cas.impl.TypeImpl;
import com.ibm.uima.jcas.impl.JCas;
import com.ibm.uima.jcas.tcas.Annotation_Type;

public class Sentence_Type extends Annotation_Type {
  protected FSGenerator getFSGenerator() {return fsGenerator;};
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (instanceOf_Type.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = instanceOf_Type.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Sentence(addr, instanceOf_Type);
  			     instanceOf_Type.jcas.putJfsFromCaddr(addr, fs);
  			     return fs;
  		     }
  		     return fs;
        } else return new Sentence(addr, instanceOf_Type);
  	  }
    };

  public final static int typeIndexID = Sentence.typeIndexID;

  public final static boolean featOkTst = JCas.getFeatOkTst("com.ibm.uima_examples.tokenizer.Sentence");

  //* initialize variables to correspond with Cas Type and Features
  public Sentence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

  }

  protected Sentence_Type() { //block default new operator
    throw new RuntimeException("Internal Error-this constructor should never be called.");  }

}

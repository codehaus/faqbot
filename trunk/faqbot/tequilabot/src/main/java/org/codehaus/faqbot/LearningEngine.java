package org.codehaus.faqbot;

import java.io.*;
import java.net.URL;

public class LearningEngine 
{
	URL loc;
	URL buf;
	
	public LearningEngine()
	{
		this("res/aiml/User.aiml");
	}
	
	public LearningEngine(String file)
	{
		loc = this.getClass().getResource(file);
		buf = this.getClass().getResource(file+".tmp");
	}
	
	public void learn(String in)
	{
		String[] toks = in.split(" ");
		if(toks[0].toLowerCase().equals("learn"))
		{
			in = in.substring(6);
			toks = in.split(" resp ");
			doLearning(toks);
		}
	}
	
	public void doLearning(String[] in)
	{
		try
		{
			File f = new File(buf.getFile());
			BufferedWriter out = new BufferedWriter(new FileWriter(f, true));
			out.append("<category><pattern>");
			out.append(in[0].toUpperCase());
			out.append("</pattern><template>");
			out.append(in[1]);
			out.append("</template></category>\n");
			out.close();
			
			BufferedReader read = new BufferedReader(new FileReader(new File(buf.getFile())));
			BufferedWriter out2 = new BufferedWriter(new FileWriter(new File(loc.getFile())));
			
			out2.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n<aiml version=\"1.0.1\" xmlns=\"http://alicebot.org/2001/AIML-1.0.1\" xmlns:html=\"http://www.w3.org/1999/xhtml\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://alicebot.org/2001/AIML-1.0.1 http://aitools.org/aiml/schema/AIML.xsd\">\n");
			while(read.ready())
			{
				out2.write(read.readLine());
				out2.write("\n");
			}
			out2.write("</aiml>");
			read.close();
			out2.close();
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
	}
}

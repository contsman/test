package test;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class FindName {
         public static void main(final String[] args) throws Exception {
                 final String path = "E:\\opennlp\\modules\\";
                 SentenceDetectorME sentenceDetector = null;
                 final InputStream modelIn3 = new FileInputStream(path + "en-sent.bin");
                 final SentenceModel model = new SentenceModel(modelIn3);
                 sentenceDetector = new SentenceDetectorME(model);

                 Tokenizer tokenizer = null;
                 final InputStream modelIn2 = new FileInputStream(path + "en-token.bin");
                 final TokenizerModel model2 = new TokenizerModel(modelIn2);
                 tokenizer = new TokenizerME(model2);

                 NameFinderME nameFinder = null;
                 final InputStream modelIn = new FileInputStream(path + "en-ner-person.bin");
                 final TokenNameFinderModel model1 = new TokenNameFinderModel(modelIn);
                 nameFinder = new NameFinderME(model1);

                 final String line = "Mr. Pierre Vinken is 61 years old. "
                                 + "Dear Miss Jones, I love you. "
                                 + "I like Tom and Jerry. "
                                 + "Tommy Lee Jones is an American actor and film director. "
                                 + "He has received three Academy Award nominations, winning one as Best Supporting Actor for the 1993 thriller film The Fugitive. "
                                 + "Steven Frederic Seagal is an American action film star, producer, writer, martial artist, guitarist and a reserve deputy sheriff. A 7th-dan black belt in Aikido, Seagal began his adult life as an Aikido instructor in Japan. He became the first foreigner to operate an Aikido Dojo in Japan.";
                 for (final String s0 : sentenceDetector.sentDetect(line)) {
                         final String tokens[] = tokenizer.tokenize(s0);
                         final Span nameSpans[] = nameFinder.find(tokens);
                         final int len = tokens.length;
                         int index = 0;
                         final StringBuilder sb = new StringBuilder();
                         for (final Span s : nameSpans) {
                                 final int start = s.getStart();
                                 final int end = s.getEnd();
                                 for (; index < start; ++index) {
                                         final String word = tokens[index];
                                         sb.append(word + " ");
                                 }
                                 sb.append("[");
                                 for (int i = start; i < end; ++i) {
                                         final String word = tokens[i];
                                         sb.append(word + " ");
                                 }
                                 sb.setLength(sb.length() - 1);
                                 sb.append("]nr ");
                                 index = end;
                         }
                         for (; index < len; ++index) {
                                 final String word = tokens[index];
                                 sb.append(word + " ");
                         }
                         sb.setLength(sb.length() - 1);
                         System.out.println(sb);
                 }
         }
}
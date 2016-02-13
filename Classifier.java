/**
 *
 * The Classifier.
 * Simple classifier based on a threshold.
 * 
 */

class Classifier{

        public String positiveLabel; 
        public String negativeLabel; 

        public int threshold;

        public Classifier(String positiveLabel,String negativeLabel){
                this.positiveLabel = positiveLabel;
                this.negativeLabel = negativeLabel;
        }
}

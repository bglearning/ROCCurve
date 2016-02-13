/**
 *
 * Application to find the ROC Curve Points for a certain classifier on a certain dataset.
 * The program invokes the classifier with different thresholds on the dataset to calculate the
 * True Positive Rate and False Positive Rate which are the two axes of the ROC Curve.
 *
 */

public class ROCCurve{ 

    /**
     * Program entry point
     * @param args command line arguments
     */
    public static void main(String[] args){

            if(args.length!=1){
                    System.out.println("Number of Data Points not supplied.");
                    System.exit(1);
            }

            int numberOfDataPoints = Integer.parseInt(args[0]);

            DataSet studentHeights = new DataSet(numberOfDataPoints);
            studentHeights.readDataPoints();

            Classifier simpleClassifier = new Classifier("f","m");

            ROC roc = studentHeights.generateROC(simpleClassifier,150,178);

            roc.displayPoints();

            roc.outputTPR();
            roc.outputTNR();

    }
}

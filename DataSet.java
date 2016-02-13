import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * The DataSet Class.
 * Responsible for reading in the data points.
 * Also evaluates and generates results for certain classifiers.
 */
class DataSet{

        private List<DataPoint> dataPoints;
        private int numberOfDataPoints;

        /**
         *
         * Inner Class to make it more convenient to process the 
         * classifier result.
         */

        class ClassifierResult{

                public int truePositiveCnt;
                public int falseNegativeCnt;
                public int falsePositiveCnt;
                public int trueNegativeCnt;

        }

        public DataSet(int numberOfDataPoints){
                this.numberOfDataPoints = numberOfDataPoints;
        }

        /**
         * Method to read Data Points in the format:  {String} {int}.
         * Example:
         * label 130
         */

        public void readDataPoints(){

            dataPoints = new ArrayList<DataPoint>();

            Scanner lineReader = new Scanner(System.in);
            int cnt = 0;
            while(lineReader.hasNextLine() && cnt<numberOfDataPoints ){

                    Scanner lineTokenizer = new Scanner(lineReader.nextLine());
                    String label;
                    int value;

                    label = lineTokenizer.next();
                    value = lineTokenizer.nextInt();

                    dataPoints.add(new DataPoint(label,value));

                    cnt++;

                    lineTokenizer.close();

            }

            lineReader.close();
            
        }

        /**
         * Method to determine number of points on the confusion matrix.
         *  The label associated with the data point is the true Label.
         *  If the value is less than the  threshold, it is classified as +ve by the classifier 
         *  If the value is greater than or equal to the  threshold, it is classified as -ve by the classifier
        */

        private ClassifierResult calculateResults(Classifier classifier){

                ClassifierResult result  = new ClassifierResult();

                for(int i=0;i<numberOfDataPoints;i++){
                        DataPoint dp = dataPoints.get(i);
                        if(dp.label.equals(classifier.positiveLabel) && dp.value < classifier.threshold){
                                result.truePositiveCnt++;
                        }else if(dp.label.equals(classifier.positiveLabel) && dp.value >= classifier.threshold){
                                result.falseNegativeCnt++;
                        }else if(dp.label.equals(classifier.negativeLabel) && dp.value < classifier.threshold){
                                result.falsePositiveCnt++;
                        }else{
                                result.trueNegativeCnt++;
                        }

                }

                return result;
        }

        /**
         * Method to generate the ROC points associated with the classifier.
         *  The threshold value is gradually changed from its low value to the high value.
         *  The ROC points are calculated for each threshold value.
         */

        public ROC generateROC(Classifier classifier, int lowThreshold, int highThreshold){

                List<ROCPoint> rocPoints = new ArrayList<ROCPoint>();

                classifier.threshold = lowThreshold;
                while(classifier.threshold<=highThreshold){
                    ClassifierResult result = calculateResults(classifier);
                    double truePositiveRate = (result.truePositiveCnt*1.0)/(result.truePositiveCnt+result.falseNegativeCnt);
                    double falsePositiveRate = (result.falsePositiveCnt*1.0)/(result.falsePositiveCnt+result.trueNegativeCnt);
                    rocPoints.add(new ROCPoint(truePositiveRate,falsePositiveRate));
                    classifier.threshold++;
                }
                return new ROC(rocPoints);
        }
}

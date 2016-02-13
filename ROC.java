import java.util.List;
import java.util.ArrayList;

/**
 *
 * The ROC class.
 * Primarily a wrapper around an arraylist of ROCPoints.
 */

class ROC{

        List<ROCPoint> rocPoints;

        public ROC(List<ROCPoint> rocPoints){
                this.rocPoints = rocPoints;
        }

        public void displayPoints(){

                for(int i=0;i<rocPoints.size();i++){
                        ROCPoint rp = rocPoints.get(i);
                        System.out.println(rp.truePositiveRate+" "+rp.trueNegativeRate);
                }
        }

        public void outputTPR(){
                for(int i=0;i<rocPoints.size();i++){
                        ROCPoint rp = rocPoints.get(i);
                        System.out.print(rp.truePositiveRate+",");
                }
                System.out.println();
        }
        public void outputTNR(){
                for(int i=0;i<rocPoints.size();i++){
                        ROCPoint rp = rocPoints.get(i);
                        System.out.print(rp.trueNegativeRate+",");
                }
                System.out.println();
        }

}


/**
 *
 * ROC Points Structure Class.
 */
class ROCPoint{

        public double truePositiveRate;
        public double trueNegativeRate;

        public ROCPoint(double truePositiveRate,double trueNegativeRate){
                this.truePositiveRate = truePositiveRate;
                this.trueNegativeRate = trueNegativeRate;
        }
}

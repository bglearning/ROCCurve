#ROC Curve Point Generator
This program generates the points on the ROC space for the given data set. The ROC curve has the True Positive Rate on the y-axis and the True 
Negative Rate on the x-axis.

###Invocation
It takes in one command line argument - the number of data points in the data set.
The input is from the standard input but directing a file into the *stdin* might be the easier option.
```
java ROCCurve 48 < sampleData
```

###The example
In the example, we create a ROC curve for a classifier that classifies students according to gender based on their heights.
The example data set consists of 80 data points consisting of the gender and heights of students.
There are 20 girls and 60 boys in the example.

The classifier simply classifies a data point with height below the threshold as positive (girl) and all others as negative (boy).
The threshold is incremented from 150 to 178 in increments of one unit. For each value of the threshold, the True Positive Rate
and the True Negative Rate are calculated to get the points for the curve. 

[!ROC Curve](genderClassifier.jpg)
This plot was created using Octave.

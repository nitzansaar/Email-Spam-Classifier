# Email Classifier Project

This repository contains code for an email classifier that uses frequency distribution and likelihood calculations to predict whether an email is spam or ham (not spam).

## Project Overview

The project consists of several classes that work together to classify emails as spam or ham:

- `TestManager`: The main class that orchestrates the classification process. It reads in training and test data, computes log-likelihoods for spam and ham emails, and displays the results.

- `Processor`: This class handles the preprocessing of email text. It removes stopwords, strips punctuation, and filters out junk words. The parsed words are then used for computing frequencies.

- `FreqDist`: A wrapper class for a hashmap that stores the frequency distribution of words in the corpus. It tracks how often each word appears and provides methods to access these frequencies.

- `Predictor`: This class computes the log-likelihood scores for a list of words given a frequency distribution. It calculates the likelihood of each word occurring in spam and ham emails.

## How to Use

1. Clone or download the repository to your local machine.

2. Compile the Java files:

javac *.java

3. Run the `TestManager` class to evaluate the email classifier:

java TestManager

4. The program will read in training data from the `spamtrain` and `hamtrain` folders and test data from the `spamtest` and `hamtest` folders.

5. It will compute log-likelihood scores for each email and determine whether it's correctly classified as spam or ham.

6. At the end, the program will display the results, including the number of correct classifications for spam and ham emails and the total score percentage.

## What I Learned

While working on this project, I learned:

- How to preprocess text data for classification tasks by removing stopwords and handling punctuation.
- How to implement a frequency distribution to track the occurrences of words in a corpus.
- How to calculate log-likelihood scores for classifying emails as spam or ham.
- How to design and implement a simple email classifier using basic machine learning concepts.

This project provided valuable insights into the process of text classification and laid the foundation for understanding more advanced techniques in the field.

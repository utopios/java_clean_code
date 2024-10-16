package com.cleancode.kata;

public class PrimePrinter {
    public static void main(String[] args) {

        final int MAX_PRIMES = 1000;
        final int ROWS_PER_PAGE = 50;
        final int COLUMNS_PER_PAGE = 4;
        final int MAX_PRIME_FACTORS = 30;
        
        int[] primes = generatePrimes(MAX_PRIMES, MAX_PRIME_FACTORS);
        printPrimes(primes, ROWS_PER_PAGE, COLUMNS_PER_PAGE, MAX_PRIMES);
	}

    private static void printPageHeader(int pageNumber, int maxPrimes) {
        System.out.println("The First " + maxPrimes + " Prime Numbers === Page " + pageNumber);
        System.out.println();
    }

    private static int[] printPrimes(int[] primes, int rowsPerPage, int columnsPerPage, int maxPrimes) {
        int pageNumber = 1;
        int pageOffset = 1;

        while (pageOffset <= maxPrimes) {
            printPageHeader(pageNumber, maxPrimes);

            for (int rowOffset = pageOffset; rowOffset < pageOffset + rowsPerPage; rowOffset++) {
                for (int column = 0; column < columnsPerPage; column++) {
                    int index = rowOffset + column * rowsPerPage;
                    if (index <= maxPrimes) {
                        System.out.printf("%10d", primes[index]);
                    }
                }
                System.out.println();
            }

            pageNumber++;
            pageOffset += rowsPerPage * columnsPerPage;
        }
    }

    private static int[] generatePrimes(int maxPrimes, int maxPrimeFactors) {
        int[] primes = new int[maxPrimes + 1];
        int[] multiples = new int[maxPrimeFactors + 1];
        int currentNumber = 1;
        int primeCount = 1;
        primes[1] = 2;
        int primeOrder = 2;
        int square = 9;

        while (primeCount < maxPrimes) {
            do {
                currentNumber += 2;
                if (currentNumber == square) {
                    primeOrder++;
                    square = primes[primeOrder] * primes[primeOrder];
                    multiples[primeOrder - 1] = currentNumber;
                }
                int numberCandidate = 2;
                boolean isPrime = true;
                while (numberCandidate < primeOrder && isPrime) {
                    while (multiples[numberCandidate] < currentNumber) {
                        multiples[numberCandidate] += primes[numberCandidate] + primes[n];
                    }
                    if (multiples[numberCandidate] == currentNumber) {
                        isPrime = false;
                    }
                    numberCandidate++;
                }
            } while (!isPrime);
            primeCount++;
            primes[primeCount] = currentNumber;
        }

        return primes;
    }
}
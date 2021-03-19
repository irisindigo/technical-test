package com.github.irisindigo.technical_test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Solution {
    public int[] solution(int K, int M, int[] A) {
        int[] frequencies = getFrequencies(M, A);

        Set<Integer> leaders = getAllLeaders(K, A, frequencies);

        return leaders.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

    private int[] getFrequencies(int M, int[] A) {
        int[] frequencies = new int[M + 1];

        for (int i : A) {
            frequencies[i - 1]++;
        }

        return frequencies;
    }

    private Set<Integer> getAllLeaders(int K, int[] A, int[] frequencies) {
        Set<Integer> leaders = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (i + K > A.length) {
                break;
            }

            int[] modifiedFrequencies = getNewFrequencies(K, A, i, frequencies);

            Optional<Integer> leader = findLeader(modifiedFrequencies, A.length);

            leader.ifPresent(leaders::add);
        }

        return leaders;
    }

    private int[] getNewFrequencies(int K, int[] A, int begin, int[] frequencies) {
        int[] newFrequencies = Arrays.copyOf(frequencies, frequencies.length);

        for (int i = begin; i < begin + K; i++) {
            newFrequencies[A[i] - 1]--;
            newFrequencies[A[i]]++;
        }

        return newFrequencies;
    }

    private Optional<Integer> findLeader(int[] frequencies, int length) {
        int maximum = 0;
        int index = -1;

        for (int i = 0; i < frequencies.length; i++) {
            int frequency = frequencies[i];

            if (maximum < frequency) {
                maximum = frequency;
                index = i;
            }
        }

        int halfLength = length / 2;
        return maximum > halfLength ? Optional.of(index + 1) : Optional.empty();
    }
}
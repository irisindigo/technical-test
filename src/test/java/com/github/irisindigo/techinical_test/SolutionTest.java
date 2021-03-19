package com.github.irisindigo.techinical_test;

import com.github.irisindigo.technical_test.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private static Solution solution;

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @Test
    void Test1() {
        int[] data = {1};
        int[] actual = SolutionTest.solution.solution(1, 1, data);
        int[] expected = new int[]{2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void Test2() {
        int[] data = {1, 2};
        int[] actual = SolutionTest.solution.solution(1, 2, data);
        int[] expected = new int[]{2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void Test3() {
        int[] data = {1, 1};
        int[] actual = SolutionTest.solution.solution(2, 1, data);
        int[] expected = new int[]{2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void Test4() {
        int[] data = new int[]{2, 1, 3, 1, 2, 2, 3};
        int[] actual = SolutionTest.solution.solution(3, 5, data);

        int[] expected = new int[]{2, 3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void Test5() {
        int[] data = new int[]{1, 2, 2, 1, 2};
        int[] actual = SolutionTest.solution.solution(4, 2, data);

        int[] expected = new int[]{2, 3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void Test6() {
        int[] data = new int[100_000];

        for (int i = 0; i < data.length / 3; i++) {
            data[i] = 1;
        }

        for (int i = data.length / 3; i < data.length; i++) {
            data[i] = 100_000;
        }

        int[] actual = SolutionTest.solution.solution(1, 100_000, data);

        int[] expected = new int[]{100_000};

        Assertions.assertArrayEquals(expected, actual);
    }
}

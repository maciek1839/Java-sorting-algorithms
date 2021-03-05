package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.BeforeEach;


class InsertSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new InsertSort(StaticValueProvider.getDataGenerator());
    }
}
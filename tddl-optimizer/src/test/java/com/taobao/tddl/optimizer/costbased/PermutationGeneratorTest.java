package com.taobao.tddl.optimizer.costbased;

import com.taobao.tddl.optimizer.utils.PermutationGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationGeneratorTest {

    @Test
    public void testNext() {
        List<Integer> elements = new ArrayList<Integer>();

        elements.add(1);
        elements.add(2);
        elements.add(3);

        PermutationGenerator instance = new PermutationGenerator(elements);

        while (instance.hasNext()) {
            List result = instance.next();
            System.out.println(result);
        }

    }
}

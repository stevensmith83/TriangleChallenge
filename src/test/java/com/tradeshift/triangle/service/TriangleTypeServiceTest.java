package com.tradeshift.triangle.service;

import static com.tradeshift.triangle.Constants.EQUILATERAL;
import static com.tradeshift.triangle.Constants.ISOSCELES;
import static com.tradeshift.triangle.Constants.NOT_A_TRIANGLE;
import static com.tradeshift.triangle.Constants.SCALENE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TriangleTypeServiceTest
{
    private TriangleTypeService underTest;

    @Before
    public void setup() throws Exception
    {
        underTest = new TriangleTypeService();
    }

    @Test
    public void shouldReturnEquilateral() throws Exception
    {
        assertEquals(underTest.getType(1, 1, 1), EQUILATERAL);
    }

    @Test
    public void shouldReturnIsosceles() throws Exception
    {
        assertEquals(underTest.getType(1, 2, 2), ISOSCELES);
        assertEquals(underTest.getType(2, 2, 1), ISOSCELES);
        assertEquals(underTest.getType(2, 1, 2), ISOSCELES);
    }

    @Test
    public void shouldReturnScalene() throws Exception
    {
        assertEquals(underTest.getType(2, 3, 4), SCALENE);
        assertEquals(underTest.getType(4, 3, 2), SCALENE);
        assertEquals(underTest.getType(4, 2, 3), SCALENE);
    }

    @Test
    public void shouldReturnNotATriangle() throws Exception
    {
        assertEquals(underTest.getType(0, 0, 0), NOT_A_TRIANGLE);
        assertEquals(underTest.getType(1, 1, 0), NOT_A_TRIANGLE);
        assertEquals(underTest.getType(1, 2, 3), NOT_A_TRIANGLE);
    }

    @Test
    public void shouldReturnNotATriangleForNegativeValues() throws Exception
    {
        assertEquals(underTest.getType(-2, -2, -3), NOT_A_TRIANGLE);
    }
}

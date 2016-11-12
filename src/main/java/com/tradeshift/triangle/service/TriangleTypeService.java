package com.tradeshift.triangle.service;

import static com.tradeshift.triangle.Constants.EQUILATERAL;
import static com.tradeshift.triangle.Constants.ISOSCELES;
import static com.tradeshift.triangle.Constants.NOT_A_TRIANGLE;
import static com.tradeshift.triangle.Constants.SCALENE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TriangleTypeService
{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public String getType(final int a, final int b, final int c)
    {
        log.info("Service call (getType) with {}, {}, {}", a, b, c);

        if (allSidesEqual(a, b, c) && isTriangle(a, b, c))
        {
            return EQUILATERAL;
        }

        if (twoSidesEqual(a, b, c) && isTriangle(a, b, c))
        {
            return ISOSCELES;
        }

        if (noEqualSides(a, b, c) && isTriangle(a, b, c))
        {
            return SCALENE;
        }

        return NOT_A_TRIANGLE;
    }

    private boolean allSidesEqual(final int a, final int b, final int c)
    {
        final boolean check = a == b && b == c;
        log.info("Service call (allSidesEqual) with {}, {}, {}: {}", a, b, c, check);
        return check;
    }

    private boolean twoSidesEqual(final int a, final int b, final int c)
    {
        final boolean check = (a == b && b != c) || (b == c && a != c) || (a == c && b != c);
        log.info("Service call (twoSidesEqual) with {}, {}, {}: {}", a, b, c, check);
        return check;
    }

    private boolean noEqualSides(final int a, final int b, final int c)
    {
        final boolean check = a != b && b != c && a != c;
        log.info("Service call (noEqualSides) with {}, {}, {}: {}", a, b, c, check);
        return check;
    }

    private boolean isTriangle(final int a, final int b, final int c)
    {
        final boolean check = a + b > c && a + c > b && b + c > a;
        log.info("Service call (isTriangle) with {}, {}, {}: {}", a, b, c, check);
        return check;
    }
}

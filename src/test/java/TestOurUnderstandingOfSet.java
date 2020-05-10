import com.dhruvk.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/*
This class shows how Set data structure handles duplicates
NOTE - Please don't change anything in this class or file, just try to get all the tests passing
 */
public class TestOurUnderstandingOfSet {

    @Nested
    @DisplayName("A set")
    class WhenUsingInBuiltType {
        @Test
        void withOneElementShouldHaveASizeOfOne() {
            HashSet<Integer> integers = new HashSet<>(singletonList(10));

            assertThat(integers.size(), is(1));
        }

        @Test
        void withTwoDifferentElementsShouldHaveASizeOfTwo() {
            HashSet<Integer> integers = new HashSet<>(asList(10, 11));

            assertThat(integers.size(), is(2));
        }

        @Test
        void withTwoEqualElementsShouldHaveASizeOfOne() {
            HashSet<Integer> integers = new HashSet<>(asList(10, 10));

            assertThat(integers.size(), is(1));
        }
    }

    @Nested
    @DisplayName("A set with elements of a custom type")
    class WhenUsingCustomType {

        @Nested
        class EqualityTests {
            @Test
            void withTwoElementsThatAreDifferentByValueShouldNotBeEqual() {
                Point origin = new Point(0, 0);
                Point differentPoint = new Point(1, 0);

                assertThat(origin, is(not(differentPoint)));
            }

            @Test
            void withTwoElementsThatAreEqualByValueShouldBeEqual() {
                Point origin = new Point(0, 0);
                Point anotherOrigin = new Point(0, 0);

                assertThat(origin, is(anotherOrigin));
            }
        }

        @Test
        void withOneElementShouldHaveASizeOfOne() {
            Point origin = new Point(0, 0);
            HashSet<Point> points = new HashSet<>(singletonList(origin));

            assertThat(points.size(), is(1));
        }

        @Test
        void withTwoDifferentElementsShouldHaveASizeOfTwo() {
            Point origin = new Point(0, 0);
            Point differentPoint = new Point(1, 0);

            HashSet<Point> points = new HashSet<>(asList(origin, differentPoint));

            assertThat(points.size(), is(2));
        }

        @Test
        void withTwoEqualElementsShouldHaveASizeOfOne() {
            Point origin = new Point(0, 0);
            Point anotherOrigin = new Point(0, 0);

            HashSet<Point> integers = new HashSet<>(asList(origin, anotherOrigin));

            assertThat(integers.size(), is(1));
        }
    }
}

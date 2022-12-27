package study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    // 요구사항 1
    // "1,2" 을 , 로 split 했을 때 1과 2로 잘 분리되는지 학습 테스트를 구현한다
    @Test
    void split1And2() {
        String[] actual = "1,2".split(",");
        assertThat(actual[0]).contains("1");
        assertThat(actual[1]).contains("2");
    }

    @Test
    void split1() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    // 요구사항 2
    // "(1,2)" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 ()을 제거하고 "1,2" 를 반환하도록 구현한다.
    @Test
    void substring() {
        String before = "(1,2)";
        String actual = before.substring(before.indexOf("(")+1);
        actual = actual.substring(0, actual.indexOf(")"));
        assertThat(actual).isEqualTo("1,2");
    }

    // 요구사항 3
    // "abc" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    // String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
    // StringIndexOutOfBoundsException 이 발생하는 하는 부분에 대한 학습 테스트를 구현한다.
    // JUnit 의 @DisplayName 을 활용해 테스트 메소드의 의도를 드러낸다.
    @Test
    void charAt() {

    }
}

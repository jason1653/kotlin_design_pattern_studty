/**
 * Strategy Pattern이란
 * - 알고리즘을 캡슐화하여 동적으로 알고리즘을 바꿀 수 있도록 하는 패턴
 * - 알고리즘을 사용하는 클라이언트와 알고리즘을 제공하는 서버를 분리
 */


/**
 * (String) -> String 타입의 함수를 인자로 받는 Printer 클래스
 */
class Printer(private val stringFormatterStrategy: (String) -> String) {

    /**
     * stringFormatterStrategy를 사용하여 value를 출력한다.
     */
    fun print(value: String) {
        println(stringFormatterStrategy(value))
    }
}

/**
 * String을 소문자로 변환하는 함수
 */
val lowerCaseFormatter = { value: String -> value.lowercase() }

/**
 * String을 대문자로 변환하는 함수
 */
val upperCaseFormatter = { value: String -> value.uppercase() }

fun main() {
    var inputString = "test"

    val printer = Printer(lowerCaseFormatter)
    printer.print(inputString)

    val printer2 = Printer(upperCaseFormatter)
    printer2.print(inputString)
}

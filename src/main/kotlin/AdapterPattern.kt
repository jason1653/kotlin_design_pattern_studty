import java.math.BigDecimal

/**
 * Adapter패턴이란
 * - 한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환한다.
 */


interface Temperature {
    var temperature: Double
}

/**
 * FahrenheitTemperature는 Temperature를 구현한다.
 * 메서드 override를 통해 temperature를 섭씨로 변환한다.
 */
class CelsiusTemperature(override var temperature: Double) : Temperature


/**
 * CelsiusTemperature는 Temperature를 구현한다.
 */
class FahrenheitTemperature(private var celsiusTemperature: CelsiusTemperature) : Temperature {

    /**
     * temperature를 섭씨로 변환한다.
     * temperature를 설정할 때는 화씨로 변환한다.
     * override를 통해 temperature를 화씨로 변환한다. interface에 정의된 temperature를 사용한다.
     */
    override var temperature: Double
        get() = convertCelsiusToFahrenheit(celsiusTemperature.temperature)
        set(temperatureInF) {
            celsiusTemperature.temperature = convertFahrenheitToCelsius(temperatureInF)
        }


    /**
     * 화씨를 섭씨로 변환한다.
     * BigDecimal을 사용하여 소수점 2자리까지 표현한다.
     * BigDecimal을 사용하지 않으면 0.0이 0.0으로 표현되어 0.0 C -> 32.0 F가 출력된다.
     */
    private fun convertFahrenheitToCelsius(f: Double): Double =
        ((BigDecimal.valueOf(f).setScale(2) - BigDecimal(32)) * BigDecimal(5) / BigDecimal(9))
            .toDouble()


    /**
     * 섭씨를 화씨로 변환한다.
     * BigDecimal을 사용하여 소수점 2자리까지 표현한다.
     * BigDecimal을 사용하지 않으면 0.0이 0.0으로 표현되어 0.0 C -> 32.0 F가 출력된다.
     */
    private fun convertCelsiusToFahrenheit(c: Double): Double =
        ((BigDecimal.valueOf(c).setScale(2) * BigDecimal(9) / BigDecimal(5)) + BigDecimal(32))
            .toDouble()
}

fun main() {
    val celsiusTemperature = CelsiusTemperature(0.0)
    val fahrenheitTemperature = FahrenheitTemperature(celsiusTemperature)

    celsiusTemperature.temperature = 36.6
    println("${celsiusTemperature.temperature} C -> ${fahrenheitTemperature.temperature} F")


    fahrenheitTemperature.temperature = 100.0
    println("${fahrenheitTemperature.temperature} F -> ${celsiusTemperature.temperature} C")

}
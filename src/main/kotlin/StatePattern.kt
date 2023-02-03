/**
 * state패턴이란
 * 객체의 상태에 따라 행동을 변경한다.
 * kotlin sealed class는 상속을 허용하지 않는다.
 */
sealed class AuthorizationState

/**
 * Authorized는 AuthorizationState를 상속받는다.
 */
object Unauthorized : AuthorizationState()

/**
 * Authorized는 AuthorizationState를 상속받는다.
 */
class Authorized(val userName: String) : AuthorizationState()

class AuthorizationPersenter {
    private var state: AuthorizationState = Unauthorized

    /**
     * isAuthorized는 getter를 통해 계산한다.
     * kotlin에서는 get 사용하여 when을 사용할 수 있고 is를 사용하여 타입을 비교한다.
     * kotlin에서는 when을 사용하여 값을 반환할 수 있다.
     */
    val isAuthorized: Boolean
        get() = when(state) {
            is Authorized -> true
            is Unauthorized -> false
        }

    /**
     * userName는 getter를 통해 계산한다.
     * kotlin에서는 get 사용하여 when을 사용할 수 있고 is를 사용하여 타입을 비교한다.
     * kotlin에서는 when을 사용하여 값을 반환할 수 있다.
     */
    val userName: String
        get() {
            return when(val state = this.state) {
                is Authorized -> state.userName
                is Unauthorized -> "Unauthorized"
            }
        }

    /**
     * 상태값을 변경한다.
     */
    fun loginUser(userName: String) {
        state = Authorized(userName)
    }

    /**
     * 상태값을 변경한다.
     */
    fun logoutUser() {
        state = Unauthorized
    }
}

fun main() {
    val authorizationPersenter = AuthorizationPersenter()
    println("authorizationPersenter = ${authorizationPersenter.isAuthorized}")
    println("authorizationPersenter = ${authorizationPersenter.userName}")

    authorizationPersenter.loginUser("user")

    println("authorizationPersenter.loginUser = ${authorizationPersenter.isAuthorized}")
    println("authorizationPersenter.loginUser = ${authorizationPersenter.userName}")


    authorizationPersenter.logoutUser()
    println("authorizationPersenter.logoutUser() = ${authorizationPersenter.isAuthorized}")
    println("authorizationPersenter.logoutUser() = ${authorizationPersenter.userName}")
}
import java.io.InputStreamReader
import java.util.Scanner

class Test {
}

data class User(var id:String, var pw:String){
init {
    this.id="admin"
    this.pw="1234"
    val email:String="111@1"
    val phone:String="010-1234-5678"
}
}

class Login(val id: String,val pw:String){
    val user=User()
    fun check(){
        this.equals(user)

    }
}


fun main(){
    val sc = Scanner(System.`in`)
    print("ID PW >>")
    var id = sc.nextLine()
    var pw = sc.nextLine()
        Login(id,pw).check()
}


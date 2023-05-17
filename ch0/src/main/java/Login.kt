class Login() {

    companion object {
        fun loginTest(admin:User){
            if(admin.email.equals("admin@test.com") && admin.pw.equals("1234")) {
                println("로그인 성공")
            }

        }
    }
}

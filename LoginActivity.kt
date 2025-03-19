package com.example.quanlychitieu

class LoginActivity : AppCompatActivity() {

    private val database by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "app_db").build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.emailEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()

            lifecycleScope.launch {
                val user = database.userDao().loginUser(email, password)
                if (user != null) {
                    Toast.makeText(this@LoginActivity, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
                    // Chuyển tới màn hình chính
                } else {
                    Toast.makeText(this@LoginActivity, "Email hoặc mật khẩu không chính xác!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

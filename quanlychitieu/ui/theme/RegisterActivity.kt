package com.example.quanlychitieu.ui.theme

class RegisterActivity : AppCompatActivity() {

    private val database by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "app_db").build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton: Button = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.emailEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()
            val confirmPassword = findViewById<EditText>(R.id.confirmPasswordEditText).text.toString()

            if (password == confirmPassword) {
                lifecycleScope.launch {
                    database.userDao().registerUser(User(email, password))
                    Toast.makeText(this@RegisterActivity, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()
                    finish() // Quay lại màn hình đăng nhập
                }
            } else {
                Toast.makeText(this, "Mật khẩu không khớp!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

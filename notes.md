Sure! Here's your text formatted cleanly for clarity and readability:

---

### 🔢 Double (Primitive Type)
Special values:

```java
Double.MAX_VALUE: The largest positive finite value (1.7976931348623157 × 10^308)
Double.MIN_VALUE: The smallest positive non-zero value (4.9 × 10^-324)
Double.POSITIVE_INFINITY: Positive infinity
Double.NEGATIVE_INFINITY: Negative infinity
Double.NaN: Not a Number (result of invalid operations like 0/0)
```

- **Largest positive value:**  
  `1.7976931348623157 × 10^308`  
  *(Written out fully:)*
  ```
  179769313486231570000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
  ```

- **Smallest positive value:**
  ```
  0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000049
  ```
  *(Which is 4.9 × 10^-324)*

- **Precision:**  
  ~15 to 17 significant decimal digits

---

### 🧮 BigDecimal (Class from `java.math`)

- **Maximum/Minimum Value:**  
  No theoretical limits — only constrained by memory

- **Precision:**  
  Arbitrary — you define the exact number of digits

- **Scale:**  
  You specify how many digits come **after** the decimal point

---

### 💻 Example Code

```java
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalExample {
    public static void main(String[] args) {
        // Creating BigDecimal values
        BigDecimal bd1 = new BigDecimal("123456789.987654321");
        BigDecimal bd2 = new BigDecimal("0.00000000000000000000000000001");
        
        // Division with precision
        BigDecimal result = bd1.divide(bd2, 34, RoundingMode.HALF_UP);
        System.out.println("Result with 34 digits precision: " + result);
        
        // Exact addition example
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        BigDecimal sum = a.add(b);
        System.out.println("0.1 + 0.2 = " + sum);  // Outputs: 0.3
    }
}
```

---

### 📌 When to Use BigDecimal

✅ Financial calculations  
✅ Currency handling  
✅ Scientific calculations with exact decimal precision  
✅ Any scenario where **rounding errors** are unacceptable

⚠️ **Tradeoff:** BigDecimal is **slower** than `double` due to its precision and object-based structure.

---

Let me know if you want this as Markdown, PDF, or in a comment-ready Java doc format!
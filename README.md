# checkstyle-method-body-top-padding

This project provides a custom [Checkstyle](https://checkstyle.org/) check named `MethodBodyTopPaddingCheck`. It enforces a style rule where each Java method body must begin with a **blank line after the opening brace** `{`.

---

## ✅ What it Checks

**Fails** if there is no blank line between the opening `{` and the first line of code inside a method:

```java
// ❌ Violates rule
public void badMethod() {
    System.out.println("First line should be after a blank line.");
}
```

```java
// ❌ Violates rule
public void badMethod() { System.out.println("First line should be after a blank line.");
}
```

**Passes** if there is a blank line after the `{`:

```java
// ✅ OK
public void goodMethod() {

    System.out.println("First line is after a blank line.");
}
```

---

## 📦 How to Use in a Java Project

### Testing Manually

1. **Build the JAR**:

   ```bash
   mvn clean package
   ```

   This will generate a JAR in `target/`, for example:

   ```
   target/method-body-top-padding-1.0-SNAPSHOT.jar
   ```

2. **Configure Checkstyle** to use your custom check:

   In your `checkstyle.xml`:

   ```xml
   <module name="Checker">
       <module name="TreeWalker">
           <module name="com.wso2.checks.MethodBodyTopPaddingCheck"/>
       </module>
   </module>
   ```

3. **Run Checkstyle**:

   ```bash
   java -classpath checkstyle-10.12.1-all.jar:target/method-body-top-padding-1.0-SNAPSHOT.jar \
        com.puppycrawl.tools.checkstyle.Main \
        -c checkstyle.xml \
        path/to/YourJavaFile.java
   ```

   > Replace the classpath separator `:` with `;` if you're on Windows.

---

## 🛠 Local Development

To modify or enhance the rule:

1. **Clone the repository** and open it in your IDE.

2. **Edit** the check in:

   ```
   src/main/java/com/wso2/checks/MethodBodyTopPaddingCheck.java
   ```

3. **Edit error messages** in:

   ```
   src/main/resources/com/wso2/checks/messages.properties
   ```

4. **Build** the JAR:

   ```bash
   mvn clean package
   ```

5. **Test** the check by running Checkstyle manually as shown above.

---

## License

MIT

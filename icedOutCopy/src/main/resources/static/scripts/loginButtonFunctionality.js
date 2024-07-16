function attachEvents() {

    const inputDOMselectors = {
        username: document.getElementById('username'),
        password: document.getElementById('password')
    };

    const otherDOMselectors = {
        loginBtn: document.getElementById('loginButton'),
        signUpBtn: document.getElementById('signupButton'),
        forgotPassword: document.getElementById('forgotPasswordLink')
    };

    if (otherDOMselectors.loginBtn) {
        otherDOMselectors.loginBtn.addEventListener('click', handleLogin);
    }

    if (otherDOMselectors.signUpBtn) {
        otherDOMselectors.signUpBtn.addEventListener('click', handleSignup);
    }

    if (otherDOMselectors.forgotPassword) {
        otherDOMselectors.forgotPassword.addEventListener('click', handleForgotPassword);
    }

    function handleLogin(event) {
        event.preventDefault();
        // Handle login logic here
        fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: inputDOMselectors.username.value,
                password: inputDOMselectors.password.value
            })
        })
            .then(response => {
                if (response.ok) {
                    window.location.href = '/dashboard'; // Redirect to dashboard on success
                } else {
                    alert("Login failed. Please check your username and password.");
                }
            })
            .catch(error => console.error('Error:', error));
    }

    function handleSignup(event) {
        event.preventDefault();
        // Handle signup logic here
        window.location.href = '/signUp'; // Redirect to signup page
    }

    function handleForgotPassword(event) {
        event.preventDefault();
        // Handle forgot password logic here
        alert("Forgot password link clicked!"); // Example alert; replace with actual logic
    }
}

// Call attachEvents function when DOM content is loaded
document.addEventListener('DOMContentLoaded', attachEvents);

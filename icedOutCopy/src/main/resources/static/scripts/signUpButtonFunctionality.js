function attachEvents() {

    const inputDOMselectors = {
        username: document.getElementById("username"),
        password: document.getElementById("password"),
        firstName: document.getElementById("firstName"),
        lastName: document.getElementById("lastName"),
        email: document.getElementById("email"),
        phoneNumber: document.getElementById("phoneNumber"),
    };

    const otherDOMselectors = {
        signUpBtn: document.getElementById("signupButton"),
    };
    if (otherDOMselectors.signUpBtn) {
        otherDOMselectors.signUpBtn.addEventListener('click', handleSignup);
    }

    function handleSignup(event) {
        event.preventDefault();

        fetch('/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: inputDOMselectors.username.value,
                password: inputDOMselectors.password.value,
                firstName:inputDOMselectors.firstName.value,
                lastName:inputDOMselectors.lastName.value,
                email: inputDOMselectors.email.value,
                phoneNumber: inputDOMselectors.phoneNumber.value
            })
        })
            .then(response => {
                if (response.ok) {
                    window.location.href = '/'; // Redirect to dashboard on success
                } else {
                    alert("Signup failed. Idk where");
                }
            })
            .catch(error => console.error('Error:', error));
    }
}
document.addEventListener('DOMContentLoaded', attachEvents);
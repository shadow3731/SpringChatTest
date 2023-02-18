let textarea = document.getElementById("chatTextField");
let button = document.getElementById("messageSendButton");
let counterField = document.getElementById("symbolsCounter");
let counterFieldValue = document.getElementById("symbolsCounterValue");

textarea.addEventListener('input', () => {
    if (textarea.value.length > 1500) {
        button.style.opacity = "35%"
        button.style.pointerEvents = "none";
        counterField.style.color = "#ff0000";
    } else if (textarea.value.length >= 2 && textarea.value.length <= 1500) {
        button.style.opacity = "70%"
        button.style.pointerEvents = "auto";
        counterField.style.color = "#ffffff";
    } else {
        button.style.opacity = "35%"
        button.style.pointerEvents = "none";
        counterField.style.color = "#888888";
    }

    counterFieldValue.innerText = textarea.value.length;
});
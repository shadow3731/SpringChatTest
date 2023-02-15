document.
    addEventListener("DOMContentLoaded", () => {
    updateContainerSize();
});

window
    .addEventListener("resize", () => {
    updateContainerSize();
});

function updateContainerSize() {
    let header = document.getElementById("header");
    let container = document.getElementById("specificContainer");
    let footer = document.getElementById("footer");

    let headerAndFooterHeight = header.scrollHeight + 2 * footer.scrollHeight;
    let containerHeight = document.documentElement.clientHeight - headerAndFooterHeight;
    container.style.height = containerHeight + "px";
}
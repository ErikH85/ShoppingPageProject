var modal = document.getElementsByClassName("modal");

window.onclick = function(event) {
    if (event.target == modal[0] || event.target == modal[1]) {
        modal[0].style.display = "none";
        modal[1].style.display = "none";
    }
}
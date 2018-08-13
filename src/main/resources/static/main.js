var modal = document.getElementsByClassName("modal");

window.onclick = function(event) {
    if (event.target == modal[0]) {
        modal[0].style.display = "none";
    } else if (event.target == modal[1]) {
        modal[1].style.display = "none";
    } else if (event.target == modal[2]) {
        modal[2].style.display = "none";
    }
}
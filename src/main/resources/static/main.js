// Get the modal
var modal = document.getElementsByClassName("modal");

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal[0] || event.target == modal[1]) {
        modal[0].style.display = "none";
        modal[1].style.display = "none";
    }
}
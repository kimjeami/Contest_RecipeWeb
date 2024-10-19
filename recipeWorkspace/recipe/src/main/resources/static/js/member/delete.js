const deleteMemberBtn = document.getElementById("deleteMemberBtn");
const modal = document.getElementById("passwordModal");
const closeModal = document.querySelector(".close");

deleteMemberBtn.onclick = function () {
    modal.style.display = "block";
}

closeModal.onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

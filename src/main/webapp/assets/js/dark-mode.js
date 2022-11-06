let modo = document.getElementById("modo");
let div = document.getElementById("prueba");

modo.addEventListener("click", function () {
    let val = div.classList.toggle("dark");
    localStorage.setItem("modo", val);
});

let valor = localStorage.getItem("modo");

if (valor == "true") {
    div.classList.add("dark");
} else {
    div.classList.remove("dark");
}
let numberInpt = 1;

function createDateInpt() {
  let newDateInpt = document.createElement("input");
  newDateInpt.setAttribute("type", "text");
  newDateInpt.setAttribute("name", "date[]");
  newDateInpt.setAttribute("id", "date" + numberInpt);
  newDateInpt.classList.add("flatpickr-input"); // Ajoutez la classe flatpickr-input pour appliquer le style Flatpickr

  let nextNumberInpt = numberInpt + 1;
  let targetName = "input-delete-date-for-js-" + nextNumberInpt;
  let targetElement = document.getElementById(targetName);

  targetElement.appendChild(newDateInpt);

  // Initialise Flatpickr sur l'élément nouvellement créé
  flatpickr("#date" + numberInpt, {
    dateFormat: "Y-m-d",
  });
}

function createDateBtn() {
  let nextNumberInpt = numberInpt + 1;

  let newDateBtn = document.createElement("button");
  newDateBtn.setAttribute("type", "button");
  newDateBtn.setAttribute("id", "delete-date-" + nextNumberInpt);
  newDateBtn.setAttribute("onclick", "removeDate.call(this)");
  newDateBtn.textContent = "X";

  let targetName = "input-delete-date-for-js-" + nextNumberInpt;
  let targetElement = document.getElementById(targetName);
  targetElement.appendChild(newDateBtn);
}

function createInptDiv() {
  let nextNumberInpt = numberInpt + 1;
  let name = "input-delete-date-for-js-" + nextNumberInpt;
  let newDiv = document.createElement("div");
  newDiv.setAttribute("id", name);

  let container = document.querySelector(".input-delete-date-container");
  container.insertAdjacentElement("beforeend", newDiv);
}

function addDate() {
  createInptDiv();
  createDateInpt();
  createDateBtn();
  numberInpt++;
}

function removeDate() {
  let idStr = this.id;
  let cls = idStr.split("-")[2];
  let currentInpt = cls.substr(cls.lastIndexOf("e") + 1);
  let divToRemove = document.getElementById("input-delete-date-for-js-" + currentInpt);

  divToRemove.remove();
}

// Appeler addDate une fois au chargement de la page pour afficher le premier champ de date


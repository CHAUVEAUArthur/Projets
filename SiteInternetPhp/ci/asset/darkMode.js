
function setDarkModePreference(darkMode) {
    localStorage.setItem('darkMode', darkMode);
}
function getDarkModePreference() {
    return localStorage.getItem('darkMode') === 'true';
}
let bodySelector = document.body;
let navSelector = document.querySelector('nav');
let btnClassSelector = document.querySelectorAll('.btn');
document.getElementById('darkModeButton').addEventListener('click', function () {
    bodySelector.classList.toggle('dark-mode');
    navSelector.classList.toggle('dark-mode');
    btnClassSelector.forEach(function (element) {
        element.classList.toggle('dark-mode');
    });
    setDarkModePreference(bodySelector.classList.contains('dark-mode'));
});
window.onload = function () {
    var darkMode = getDarkModePreference();
    if (darkMode) {
        bodySelector.classList.add('dark-mode');
        navSelector.classList.add('dark-mode');
        btnClassSelector.forEach(function (element) {
            element.classList.add('dark-mode');
        });
    }
};
/*
document.getElementById('darkModeButton').addEventListener('click', function () {
    bodySelector.classList.toggle('dark-mode');
    navSelector.classList.toggle('dark-mode');
    btnClassSelector.forEach(function (element) {
        element.classList.toggle('dark-mode');
    });
    setDarkModePreference(bodySelector.classList.contains('dark-mode'));
});
*/









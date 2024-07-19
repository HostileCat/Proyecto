document.addEventListener('DOMContentLoaded', function () {
  const user__icon = document.getElementById('user__icon');
  const hiddenActions = document.getElementById('hidden__actions');

  user__icon.addEventListener('click', function () {
      hiddenActions.classList.toggle('show');
  });
});

document.addEventListener('DOMContentLoaded', function () {
  const mainMenu = document.getElementById('main__menu');
  const arrow = document.getElementById('arrow');
  const mainSelectCategory = document.getElementById('main__selectCategory');
  const mainSelectDish = document.getElementById('main__selectDish');

  arrow.addEventListener('click', function () {
    mainSelectCategory.classList.toggle('show');
    mainSelectDish.classList.toggle('show');
    arrow.classList.toggle('show');
    mainMenu.classList.toggle('show');
  });
});




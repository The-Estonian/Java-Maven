console.log('SCRIPT LOADED');

const selectRoot = document.querySelector('.root');

selectRoot.innerHTML = 'Here comes data:';

fetch('http://localhost:8080/data')
  .then((response) => response.json())
  .then((data) => {
    data.forEach((element) => {
      let newEle = document.createElement('p');
      newEle.innerHTML = element.field;
      selectRoot.appendChild(newEle);
    });
  });

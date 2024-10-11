console.log('SCRIPT LOADED');

const fetchDataFromServer = (e) => {
  e.preventDefault();
  fetch('http://localhost:8080/products')
    .then((response) => response.json())
    .then((data) => {
      listData.innerHTML = '';
      data.forEach((element) => {
        console.log(element);
        let newEleContainer = document.createElement('div');
        let newId = document.createElement('p');
        newId.innerHTML = element.id;
        let newName = document.createElement('p');
        newName.innerHTML = element.name;
        let newDescr = document.createElement('p');
        newDescr.innerHTML = element.description;
        let newPrice = document.createElement('p');
        newPrice.innerHTML = element.price;
        let newUserid = document.createElement('p');
        newUserid.innerHTML = element.userId;

        newEleContainer.appendChild(newId);
        newEleContainer.appendChild(newName);
        newEleContainer.appendChild(newDescr);
        newEleContainer.appendChild(newPrice);
        newEleContainer.appendChild(newUserid);
        newEleContainer.style.margin = "0.5rem"
        newEleContainer.style.border = "2px solid black"
        listData.appendChild(newEleContainer);
      });
    });
};
// description: "This is a sample product description."
// ​
// id: "6708fab65519915f3cd35a58"
// ​
// name: ""
// ​
// price: 19.99
// ​
// userId: "11"
const addProduct = (e) => {
  e.preventDefault();
  const newProduct = {
    name: datainput.value,
    description: 'This is a sample product description.',
    price: 19.99,
    userId: '11',
  };
  fetch('http://localhost:8080/products', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(newProduct),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
    });
};

const selectRoot = document.querySelector('.root');

const inputElement = document.createElement('div');
const inputSpan = document.createElement('span');
inputSpan.innerHTML = 'Add data: ';
const datainput = document.createElement('input');

const dataSubmit = document.createElement('input');
dataSubmit.type = 'submit';
dataSubmit.addEventListener('click', addProduct);

inputElement.appendChild(inputSpan);
inputElement.appendChild(datainput);
inputElement.appendChild(dataSubmit);

const outputElement = document.createElement('div');
const listData = document.createElement('div');
const getData = document.createElement('button');
getData.innerHTML = 'Get Data';
getData.addEventListener('click', fetchDataFromServer);

outputElement.appendChild(getData);
outputElement.appendChild(listData);

selectRoot.appendChild(inputElement);
selectRoot.appendChild(outputElement);

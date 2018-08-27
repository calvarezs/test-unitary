import axios from 'axios';
import { push } from 'react-router-redux';

export function addProducts(product) {
    return dispatch =>{
    axios.post('http://localhost:8082/products', { product })
    .then(res => {
      console.log(res);
      console.log(res.data);
    })
  };
}

export function addProducts2(product){
  return dispatch => {
    console.log(product);
    console.log(product.productCode);
    fetch('http://localhost:8082/products', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        "productCode": product.productCode,
        "productName": product.productName,
        "productDueDate": product.productDueDate,
        "productPrice": product.productPrice,
        "category": {
          "categoryId": product.category
        }
      })
    })
    .then(response => {
    })
    .catch(error => {
        console.error(error);
    });
}
}

export function editProducts(product) {
  return dispatch => {
    fetch('http://localhost:8082/products/'+product.productId, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        "productCode": product.productCode,
        "productName": product.productName,
        "productDueDate": product.productDueDate,
        "productPrice": product.productPrice,
        "category": {
          "categoryId": product.category
        }
      })
    })
    .then(response => {

    })
    .catch(error => {
        console.error(error);
    });
}
}


export function deleteProducts(id) {
  return dispatch => {
      axios.delete('http://localhost:8082/products/'+id)
          .then(response => {

          })
          .catch(error => {
              console.error(error);
          });
  };
}


export function getProducts() {
    return dispatch => {
        axios.get('http://localhost:8082/products')
            .then(response => {
            })
            .catch(error => {
                console.error(error);
            });
    };
}

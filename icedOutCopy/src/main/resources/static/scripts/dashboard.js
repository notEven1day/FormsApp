document.addEventListener("DOMContentLoaded", function() {
    const itemContainer = document.getElementById("itemContainer");

    fetch('/api/products')
        .then(response => response.json())
        .then(data => {
            data.forEach(product => {
                const item = createElement('div', itemContainer, null, ['item']);
                createElement('img', item, null, null, null, { src: product.imageUrl, alt: product.name });
                createElement('h3', item, product.name);
                createElement('p', item, product.description);
                createElement('p', item, `Price: ${product.price}`);
            });
        })
        .catch(error => console.error('Error fetching products:', error));



     function createElement(type, parentNode, content, classes, id, attributes, useInnerHTML){
        const htmlElement = document.createElement(type);

        if(content && useInnerHTML){
            htmlElement.innerHTML = content;
        }else{
            if(content && type !== 'input'){
                htmlElement.textContent = content;
            }

            if(content && type === 'input'){
                htmlElement.value = content;
            }
        }

        if(classes && classes.length > 0){
            htmlElement.classList.add(...classes);
        }


        if(id){
            htmlElement.id = id;
        }
        //--------
        if(attributes){
            for (const key in attributes) {
                htmlElement[key] = attributes[key];
            }
        }

        if(parentNode){
            parentNode.appendChild(htmlElement);
        }


        return htmlElement;
    }


});




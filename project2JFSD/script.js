const searchForm = document.querySelector('#searchForm');
const searchInput = document.querySelector('#search');
const resultsList = document.querySelector('#results');
const randomMealBtn = document.querySelector('#randomMeal');

// Event listener for search form
searchForm.addEventListener('submit', (e) => {
    e.preventDefault();
    searchRecipes();
});

// Event listener for random meal button
randomMealBtn.addEventListener('click', () => {
    getRandomMeal();
});

// Function to search recipes
async function searchRecipes() {
    const searchValue = searchInput.value.trim();
    if (searchValue === '') {
        resultsList.innerHTML = `<p>Please enter a meal name.</p>`;
        return;
    }

    try {
        const response = await fetch(`https://www.themealdb.com/api/json/v1/1/search.php?s=${searchValue}`);
        
        if (!response.ok) {
            throw new Error(`API error: ${response.status}`);
        }

        const data = await response.json();

        if (data.meals) {
            displayRecipes(data.meals);
        } else {
            resultsList.innerHTML = `<p>No recipes found. Try a different search!</p>`;
        }
    } catch (error) {
        console.error('Error fetching data:', error);
        resultsList.innerHTML = `<p>Failed to fetch recipes. Please try again later.</p>`;
    }
}

// Function to display recipes
function displayRecipes(recipes) {
    let html = '';
    recipes.forEach((recipe) => {
        html += `
        <div>
            <img src="${recipe.strMealThumb}" alt="${recipe.strMeal}">
            <h3>${recipe.strMeal}</h3>
            <ul>
                ${getIngredients(recipe)}
            </ul>
            <a href="${recipe.strSource || '#'}" target="_blank">View Recipe</a>
        </div>
        `;
    });
    resultsList.innerHTML = html;
}

// Function to get random meal
async function getRandomMeal() {
    try {
        const response = await fetch(`https://www.themealdb.com/api/json/v1/1/random.php`);
        if (!response.ok) {
            throw new Error(`API error: ${response.status}`);
        }

        const data = await response.json();
        if (data.meals) {
            displayRecipes(data.meals);
        }
    } catch (error) {
        console.error('Error fetching data:', error);
        resultsList.innerHTML = `<p>Failed to fetch a random meal. Please try again later.</p>`;
    }
}

// Helper function to get ingredients dynamically
function getIngredients(recipe) {
    let ingredientsList = '';
    for (let i = 1; i <= 20; i++) {
        const ingredient = recipe[`strIngredient${i}`];
        const measure = recipe[`strMeasure${i}`];
        
        if (ingredient && ingredient.trim() !== '') {
            ingredientsList += `<li>${measure ? measure : ''} ${ingredient}</li>`;
        }
    }
    return ingredientsList;
}

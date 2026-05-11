const userListElement = document.getElementById('userList');
const searchInput = document.getElementById('searchInput');
let allUsers = []; 

// 1. FETCH UTENTI
async function fetchUsers() {
    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/users');
        allUsers = await response.json();
        renderUsers(allUsers);
    } catch (error) {
        console.error("Errore nel caricamento:", error);
    }
}

// 2. RENDER LISTA UTENTI
function renderUsers(users) {
    userListElement.innerHTML = ""; 
    users.forEach(user => {
        const li = document.createElement('li');
        li.className = 'user-card';
        li.innerHTML = `
            <div class="user-info">
                <h3>${user.name}</h3>
                <p>${user.email}</p>
            </div>
            <a href="dettaglio.html?id=${user.id}" class="btn-dettaglio">Dettagli →</a>
        `;
        userListElement.appendChild(li);
    });
}

// 3. FILTRARE UTENTI
searchInput.addEventListener('input', (e) => {
    const term = e.target.value.toLowerCase();
    const filtered = allUsers.filter(u => u.name.toLowerCase().includes(term));
    renderUsers(filtered);
});

fetchUsers();
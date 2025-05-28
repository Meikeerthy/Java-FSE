class Event {
  constructor(name, date, seats, category) {
    this.name = name;
    this.date = new Date(date);
    this.seats = seats;
    this.category = category;
  }
  checkAvailability() {
    return this.seats > 0 && this.date > new Date();
  }
}

const events = [
  new Event("Jazz Night", "2025-06-30", 20, "Music"),
  new Event("Baking Workshop", "2025-06-15", 0, "Workshop"),
  new Event("Tech Seminar", "2025-12-20", 10, "Seminar"),
  new Event("Guitar Lessons", "2025-07-05", 5, "Music"),
  new Event("Painting Class", "2025-08-10", 12, "Workshop"),
  new Event("Career Talk", "2025-09-15", 25, "Seminar"),
  new Event("Drum Circle", "2025-06-22", 18, "Music"),
  new Event("Bread Making", "2025-10-01", 8, "Workshop"),
  new Event("Yoga Retreat", "2025-11-10", 15, "Workshop") // new event added
];

const eventsContainer = document.getElementById("eventsContainer");
const registrationForm = document.getElementById("registrationForm");
const categoryFilter = document.getElementById("categoryFilter");
const searchInput = document.getElementById("searchInput");
const eventSelect = document.getElementById("eventSelect");
const spinner = document.getElementById("spinner");
const message = document.getElementById("message");

let selectedEventName = null;

function renderEvents(eventList) {
  eventsContainer.innerHTML = "";
  eventList.forEach(event => {
    if (!event.checkAvailability()) return;
    const card = document.createElement("div");
    card.className = "event-card";
    card.tabIndex = 0; // make focusable for keyboard accessibility
    card.innerHTML = `
      <h3>${event.name}</h3>
      <p><strong>Date:</strong> ${event.date.toDateString()}</p>
      <p><strong>Seats left:</strong> ${event.seats}</p>
      <p><strong>Category:</strong> ${event.category}</p>
    `;
    card.addEventListener("click", () => {
      selectEvent(event.name, card);
    });
    card.addEventListener("keydown", (e) => {
      if (e.key === "Enter" || e.key === " ") {
        e.preventDefault();
        selectEvent(event.name, card);
      }
    });

    // Highlight if selected
    if (event.name === selectedEventName) {
      card.classList.add("selected");
    }

    eventsContainer.appendChild(card);
  });

  updateEventSelect(eventList.filter(e => e.checkAvailability()));
}

function selectEvent(eventName, cardElement) {
  selectedEventName = eventName;
  // Remove previous selection highlight
  const cards = document.querySelectorAll(".event-card");
  cards.forEach(c => c.classList.remove("selected"));
  // Highlight current
  cardElement.classList.add("selected");
  // Update select box in form
  eventSelect.value = eventName;
  eventSelect.focus();
}

function updateEventSelect(eventList) {
  eventSelect.innerHTML = "";
  eventList.forEach(e => {
    const option = document.createElement("option");
    option.value = e.name;
    option.textContent = e.name;
    eventSelect.appendChild(option);
  });

  // If previously selected event no longer in list, clear selection
  if (!eventList.find(e => e.name === selectedEventName)) {
    selectedEventName = null;
  }

  if (selectedEventName) {
    eventSelect.value = selectedEventName;
  }
}

function filterAndRender() {
  const selectedCategory = categoryFilter.value;
  const keyword = searchInput.value.toLowerCase();
  const filtered = events.filter(event => {
    const matchesCategory = selectedCategory === "all" || event.category === selectedCategory;
    const matchesName = event.name.toLowerCase().includes(keyword);
    return matchesCategory && matchesName;
  });
  renderEvents(filtered);
}

categoryFilter.addEventListener("change", filterAndRender);
searchInput.addEventListener("input", filterAndRender);

registrationForm.addEventListener("submit", e => {
  e.preventDefault();
  message.textContent = "";
  spinner.style.display = "block";

  const formData = new FormData(registrationForm);
  const userData = {
    name: formData.get("name"),
    email: formData.get("email"),
    event: formData.get("event")
  };

  console.log("Submitting registration with data:", userData);

  simulatePostRegistration(userData)
    .then(response => {
      console.log("Registration successful:", response);
      message.innerHTML = `<div class='success'>${response.message}</div>`;

      // Decrease seats for registered event
      const ev = events.find(ev => ev.name === userData.event);
      if (ev) {
        ev.seats--;
        filterAndRender(); // refresh list and form
      }
      registrationForm.reset();
      selectedEventName = null;
    })
    .catch(err => {
      console.error("Registration failed:", err);
      message.innerHTML = `<div class='error'>${err.message}</div>`;
    })
    .finally(() => {
      spinner.style.display = "none";
    });
});

function simulatePostRegistration(data) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (data.name.toLowerCase() === "fail") {
        reject({ message: "Simulated registration failure." });
      } else {
        resolve({ message: `Successfully registered for ${data.event}, ${data.name}!` });
      }
    }, 1200);
  });
}

// Initial render
filterAndRender();

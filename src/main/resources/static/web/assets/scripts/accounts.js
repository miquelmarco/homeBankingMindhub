let { createApp } = Vue;

createApp({
    data() {
        return {
            clientName: '',
            accounts: [],
            loans: [],
            isNavbarOpen: false
        }
    },
    created() {
        this.loadData()
    },
    methods: {
        loadData() {
            axios.get(`http://localhost:8080/api/clients/current`)
                .then(res => {
                    this.client = res.data
                    this.clientName = this.client.firstName + ' ' + this.client.lastName
                    this.accounts = this.client.accounts.sort((a, b) => a.id - b.id)
                    this.loans = this.client.loans.sort((a, b) => a.id - b.id)
                    console.log(this.client)
                }).catch(err => console.log(err))
        },
        sessionLogOut() {
            axios.post("/api/logout")
                .then(res => {
                    window.location.href = "/web/index.html"
                    console.log("signedOUT")
                }).catch(err => { console.log(err) })
        }
    }
}).mount("#app")

// axios.post('/api/logout').then(response => console.log('signed out!!!'))
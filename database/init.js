db = db.getSiblingDB('bookstore')
db.createCollection('books')
db.createCollection('authors')
db.createCollection('customers')

db.createUser({
    user: 'bookstoreapp',
    pwd: 'bookstoreapp',
    roles: [{
        role: 'readWrite',
        db: 'bookstore'
    }]
})
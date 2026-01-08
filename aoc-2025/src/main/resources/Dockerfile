FROM node:18-slim

COPY package.json .
COPY tsconfig.json .

RUN npm install

CMD ["npm", "run", "run-hello"]



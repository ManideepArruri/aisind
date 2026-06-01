const express = require("express");
const http = require("http");
const socketIo = require("socket.io");
const cors = require("cors");
const morgan = require("morgan");
const logger = require("./utils/logger"); // custom logger utility

const app = express();
const server = http.createServer(app);
const io = socketIo(server, {
  cors: { origin: "*" }
});

app.use(cors());
app.use(express.json());

// Morgan logs → Winston
app.use(morgan("combined", { stream: logger.stream }));

// Import routes
const notifyRoutes = require("./routes/notifyRoutes")(io);
app.use("/notify", notifyRoutes);

// Socket.IO connection
io.on("connection", (socket) => {
  logger.info(`Client connected: ${socket.id}`);

  socket.on("joinRoom", (role) => {
    socket.join(role);
    logger.info(`Client ${socket.id} joined room: ${role}`);
  });

  socket.on("disconnect", () => {
    logger.info(`Client disconnected: ${socket.id}`);
  });
});

const PORT = 4000;
server.listen(PORT, () => {
  logger.info(` Notification service running on port ${PORT}`);
});

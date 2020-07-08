# Flight Craftmulator

## Events

### ShipBodyUpdate

* Triggered by block placement
* Checks if there is a wheel block in the radius of the new block.
* Checks if the block is connected with the wheel.

### ShipPropertiesUpdate

* Triggered by ShipBodyChanged
* Recomputes the properties of the ship based on the blocks composing it.

### ShipWheelActivated



### ShipWheelDeactivated



## State Machines



## Ship



### Listens to

* ShipPropertiesChanged
* KeyPressed
* Tick
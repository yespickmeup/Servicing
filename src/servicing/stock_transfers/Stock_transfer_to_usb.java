/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

import servicing.inventory.Inventory;
import servicing.receipts.Stock_transfers_items;
import servicing.receipts.Stock_transfers_items.to_stock_transfers_items;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ronescape
 */
public class Stock_transfer_to_usb implements Serializable {

    public final List<Inventory.to_inventory> inventory_items;
    public final List<Stock_transfers.to_stock_transfers> transfers;
    public final List<Stock_transfers_items.to_stock_transfers_items> transfer_items;

    public Stock_transfer_to_usb(List<Inventory.to_inventory> inventory_items, List<Stock_transfers.to_stock_transfers> transfers, List<to_stock_transfers_items> transfer_items) {
        this.inventory_items = inventory_items;
        this.transfers = transfers;
        this.transfer_items = transfer_items;
    }

}
